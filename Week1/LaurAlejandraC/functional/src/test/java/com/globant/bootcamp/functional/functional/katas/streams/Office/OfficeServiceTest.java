package com.globant.bootcamp.functional.functional.katas.streams.Office;

import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Element;
import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Office;
import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Table;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;

public class OfficeServiceTest {

    private Office office;

    @Before
    public void setUp() throws Exception {
        Table table1 = new Table(Arrays.asList(new Element("Paper"),new Element("pencil"),new Element("laptop")));
        Table table2 = new Table(Arrays.asList(new Element("Cable"),new Element("Mouse"),new Element("keyboard")));
        Table table3 = new Table(Arrays.asList(new Element("purse"),new Element("monitor"),new Element("headphones")));
        Table table4 = new Table(Arrays.asList(new Element("iphone"),new Element("folder"),new Element("food")));
        office = new Office(Arrays.asList(table1,table2,table3,table4));
    }


    @Test
    public void first7ElementsOrdered() {
        OfficeService os = new OfficeService();
        Assert.assertThat(os.retrieveAllElements(office).toString(), is("[Cable, Mouse, Paper, folder, food, headphones, iphone]"));
    }
}
