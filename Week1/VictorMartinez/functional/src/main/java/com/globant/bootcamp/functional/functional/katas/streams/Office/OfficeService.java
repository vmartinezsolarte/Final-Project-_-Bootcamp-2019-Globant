package com.globant.bootcamp.functional.functional.katas.streams.Office;

import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Element;
import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Office;
import com.globant.bootcamp.functional.functional.katas.streams.Office.domain.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.*;

public class OfficeService {

	public List<Element> retrieveAllElements(Office  office){  //Acordate de quitar el Static
        List<Element> eList = new ArrayList<Element>();
        
        eList = office.getTables()
        				.stream()
        				.map(table->table.getElements())
        				.flatMap(x->x.stream())
        				.sorted(Comparator.comparing(Element::getName,String.CASE_INSENSITIVE_ORDER))
        				.collect(Collectors.toList());
        return eList;
    }
	
	public void print7Elements(List<Element> eList) {
		eList.stream()
			 .limit(7)
			 .forEach(x->System.out.println(x.getName()));
	}

}
