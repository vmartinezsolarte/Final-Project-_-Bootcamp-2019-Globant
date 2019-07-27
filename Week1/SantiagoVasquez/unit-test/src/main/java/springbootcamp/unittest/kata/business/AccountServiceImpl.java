package springbootcamp.unittest.kata.business;

import javax.security.auth.login.AccountException;

import springbootcamp.unittest.kata.data.AccountRepository;
import springbootcamp.unittest.kata.domain.Account;
import springbootcamp.unittest.kata.domain.AccountType;
import springbootcamp.unittest.kata.domain.TransferResponse;

public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;
    private static AccountServiceImpl accountServiceSingleton;

    private AccountServiceImpl(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public static AccountServiceImpl getInstance(AccountRepository accountRepository) {
        if (accountServiceSingleton == null) {
            return new AccountServiceImpl(accountRepository);
        }
        return accountServiceSingleton;
    }

    @Override
    public Account retrieveAccount(final String username, final AccountType accountType) {
        return accountRepository.findAccountByUsernameAndType(username, accountType);
    }

    @Override
    public TransferResponse transferMoney(final Account currentAccount, final Account savingAccount, final int amount) throws AccountException {
        if (currentAccount.getBalance() < amount) {
            throw new AccountException("insufficient funds");
        }
        
        int balanceCurrentAccount = currentAccount.getBalance() - amount;
        int balanceSavingAccount = savingAccount.getBalance() + amount;
        
        currentAccount.setBalance(balanceCurrentAccount);
        savingAccount.setBalance(balanceSavingAccount);
        
        Account newCurrentAccount = accountRepository.updateAccount(currentAccount);
        Account newSavingAccount = accountRepository.updateAccount(savingAccount);
        
        return new TransferResponse(newCurrentAccount, newSavingAccount);
    }

}
