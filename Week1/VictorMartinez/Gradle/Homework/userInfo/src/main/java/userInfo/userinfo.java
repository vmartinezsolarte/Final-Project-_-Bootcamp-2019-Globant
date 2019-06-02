package userInfo;

class userinfo extends DefaultTask{

        def userName = "Pepito Perez"
        def passWord = "******"

        @TaskAction
        def newUser(){
                println "New USer"
        }

        String getUserName(){
        return userName;
        }

        String getPassWord(){
        return passWord;
        }
}


