package com.cloud;

import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.internal.io.ResourceFactory;

import java.io.File;

/**
 * Created by ICE on 2017/8/26.
 */
public class Drools {

    public static void main(String [] args){
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String rules = compiler.compile(ResourceFactory.newClassPathResource("rules" + File.separator + "rule.xlsx", "UTF-8"), "rule-table");
        System.out.println(rules);
    }



}
