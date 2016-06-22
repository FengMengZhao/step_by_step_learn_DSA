package org.fmz.container ;

import java.util.EmptyStackException ;

public class BracketsMatch{

	public static boolean bracketsMatch(String str){
		char[] char_ary = str.toCharArray() ;

        // 本包中的类不需要导入
        Stack sta = new Stack() ; 

		for(int i=0; i<char_ary.length; i++){
			char c = char_ary[i] ;
			try{
				switch(c){
					case '(': sta.push('(') ;
						break ;
					case '[': sta.push('[') ;
						break ;
					case '{': sta.push('{') ;
						break ;
					case '<': sta.push('<') ;
						break ;
					case ')':
						if(sta.top().equals('(')){
							sta.pop() ;
							break ;
						}else
							return false ;
					case ']':
						if(sta.top().equals('[')){
							sta.pop() ;
							break ;
						}else
							return false ;
					case '}':
						if(sta.top().equals('{')){
							sta.pop() ;
							break ;
						}else
							return false ;
					case '>':
						if(sta.top().equals('<')){
							sta.pop() ;
							break ;
						}else
							return false ;
				}
 			}catch(EmptyStackException ese){
 				return false ;
			}
		}
		return sta.isEmpty() ;
	}
	public static void main(String args[]){
		String str = "{()[][()][]}" ; //output: ture
		//String str = "[(])" ; //output: false
		boolean result = bracketsMatch(str) ;
		System.out.println(result) ;
    }	
}
