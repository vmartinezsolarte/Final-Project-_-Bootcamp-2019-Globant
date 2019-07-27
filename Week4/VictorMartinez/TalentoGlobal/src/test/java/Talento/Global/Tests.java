package Talento.Global;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;


public class Tests {



        @Test
        public void testReadFile(){
            Assert.assertThat("1234", is("1234"));
        }

}
