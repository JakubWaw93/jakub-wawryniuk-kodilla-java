package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreanMain {
    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String textToDecorate = "Example text open for decorations";
        poemBeautifier.beautify(textToDecorate, (string -> string.toUpperCase()));
        poemBeautifier.beautify(textToDecorate,(string -> {
            StringBuilder sb = new StringBuilder();
            sb.append("ABC-"+textToDecorate+"-ABC");
            return sb.toString();
        }));
        poemBeautifier.beautify(textToDecorate,(string -> {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<textToDecorate.length();i++){
                if(!Character.isSpaceChar(textToDecorate.charAt(i))) {
                    sb.append(textToDecorate.charAt(i) + " ");
                }
            }
            return sb.toString();
        }));

        poemBeautifier.beautify(textToDecorate,(string -> {
            String textDecorated="";
            for(int i=0; i<textToDecorate.length();i++){
                if(i%2==0) {
                    textDecorated+=Character.toUpperCase(textToDecorate.charAt(i));
                }else{
                    textDecorated+=Character.toLowerCase(textToDecorate.charAt(i));
                }
            }
            return textDecorated;
        }));

        String anotherTextToDecorate = "Another example text open for decorations";
        poemBeautifier.beautify(anotherTextToDecorate, (string -> string.toUpperCase()));
        poemBeautifier.beautify(anotherTextToDecorate,(string -> {
            StringBuilder sb = new StringBuilder();
            sb.append("ABC-"+anotherTextToDecorate+"-ABC");
            return sb.toString();
        }));
        poemBeautifier.beautify(anotherTextToDecorate,(string -> {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<anotherTextToDecorate.length();i++){
                if(!Character.isSpaceChar(anotherTextToDecorate.charAt(i))) {
                    sb.append(anotherTextToDecorate.charAt(i) + " ");
                }
            }
            return sb.toString();
        }));

        poemBeautifier.beautify(anotherTextToDecorate,(string -> {
            String textDecorated="";
            for(int i=0; i<anotherTextToDecorate.length();i++){
                if(i%2==0) {
                    textDecorated+=Character.toUpperCase(anotherTextToDecorate.charAt(i));
                }else{
                    textDecorated+=Character.toLowerCase(anotherTextToDecorate.charAt(i));
                }
            }
            return textDecorated;
        }));
    }
}
