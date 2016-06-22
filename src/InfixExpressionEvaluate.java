import java.util.* ;

public class InfixExpressionEvaluate{

	public static int compare(char x, char y){
		switch(x){
			case '+':
				switch(y){
					case '+': return -1 ;
					case '-': return -1 ;
					case '*': return -1 ;
					case '/': return -1 ;
					case '^': return -1 ;
					case '!': return -1 ;
					case '(': return 1 ;
					case ')': return 2 ;
					case '$': return 1 ;
				}
			case '-':
				switch(y){
					case '+': return -1 ;
					case '-': return -1 ;
					case '*': return -1 ;
					case '/': return -1 ;
					case '^': return -1 ;
					case '!': return -1 ;
					case '(': return 1 ;
					case ')': return 2 ;
					case '$': return 1 ;
				}
			case '*':
				switch(y){
					case '+': return 1 ;
					case '-': return 1 ;
					case '*': return -1 ;
					case '/': return -1 ;
					case '^': return -1 ;
					case '!': return -1 ;
					case '(': return 1 ;
					case ')': return 2 ;
					case '$': return 1 ;
				}
			case '/':
				switch(y){
					case '+': return 1 ;
					case '-': return 1 ;
					case '*': return -1 ;
					case '/': return -1 ;
					case '^': return -1 ;
					case '!': return -1 ;
					case '(': return 1 ;
					case ')': return 2 ;
					case '$': return 1 ;
				}
			case '^':
				switch(y){
					case '+': return 1 ;
					case '-': return 1 ;
					case '*': return 1 ;
					case '/': return 1 ;
					case '^': return -1 ;
					case '!': return -1 ;
					case '(': return 1 ;
					case ')': return 2 ;
					case '$': return 1 ;
				}
			case '!':
				switch(y){
					case '+': return 1 ;
					case '-': return 1 ;
					case '*': return 1 ;
					case '/': return 1 ;
					case '^': return 1 ;
					case '!': return -1 ;
					case '(': return 1 ;
					case ')': return 2 ;
					case '$': return 1 ;
				}
			case '(':
				switch(y){
					case '+': return 1 ;
					case '-': return 1 ;
					case '*': return 1 ;
					case '/': return 1 ;
					case '^': return 1 ;
					case '!': return 2 ;
					case '(': return 1 ;
					case ')': return 2 ;
					case '$': return 1 ;
				}
			case ')':
				switch(y){
					case '+': return -1 ;
					case '-': return -1 ;
					case '*': return -1 ;
					case '/': return -1 ;
					case '^': return -1 ;
					case '!': return -1 ;
					case '(': return 0 ;
					case ')': return 2 ;
					case '$': return 2 ;
				}
			case '$':
				switch(y){
					case '+': return -1 ;
					case '-': return -1 ;
					case '*': return -1 ;
					case '/': return -1 ;
					case '^': return -1 ;
					case '!': return -1 ;
					case '(': return 2 ;
					case ')': return 2 ;
					case '$': return 0 ;
				}
		}
		return 3 ;
	}

	public static int factorial(int n){
		if(n < 0){
			System.exit(1) ;
		}
		if(n == 0){
			return 1 ;
		}

		int fac = 1 ;
		while(n > 1){
			fac *= n-- ;
		}
		return fac ;
	}

	public static int operate(char x, int first, int folloing){
		switch(x){
			case '+': return folloing + first ;
			case '-': return folloing - first ;
			case '*': return folloing * first ;
			case '/': return folloing / first ;
			case '^':
				int exponential = 1 ; 
				while(first > 0){
					exponential *= folloing ;
					first -- ;
				}
				return exponential ;
		}
		return -1 ;
	}

	public static int evaluate(char[] infix_expr){
		Stack<Character> operator_stack = new Stack<Character>() ;
		Stack<Integer> digital_stack = new Stack<Integer>() ;
		operator_stack.push('$') ;
		for(int i=0; i<infix_expr.length; i++){
			if(Character.isDigit(infix_expr[i])){
				int read_number = Character.getNumericValue(infix_expr[i]) ;
				int j = i ;
				while(Character.isDigit(infix_expr[++j])){
					read_number = read_number*10 + Character.getNumericValue(infix_expr[j]) ;
				}
				i = j - 1 ;
				digital_stack.push(read_number) ;
			}else{
				if(compare(infix_expr[i], operator_stack.peek()) == 1)
					operator_stack.push(infix_expr[i]) ;
				else if(compare(infix_expr[i], operator_stack.peek()) == 0)
					operator_stack.pop() ;
				else if(compare(infix_expr[i], operator_stack.peek()) == -1){
					if(operator_stack.peek().equals('!')){
						operator_stack.pop() ;
						int digital_cal = digital_stack.pop() ;
						digital_stack.push(factorial(digital_cal)) ;
						
					}
					else{
						char operate_cal = operator_stack.pop() ;
						int digital_first = digital_stack.pop() ;
						int digital_following = digital_stack.pop() ;							
						digital_stack.push(operate(operate_cal, digital_first, digital_following)) ;
					}
					i -- ;
				}
				else{
					System.err.println("Something error.") ;
					return -1 ;
				}
			}
		}
		return digital_stack.pop() ;
	}

	public static void main(String args[]){
		String infix_expression = "(1+2^3!-4)*(5!-(6-(7-(89-0!))))" ;
		int result = evaluate(infix_expression.concat("$").toCharArray()) ;
		System.out.println(result) ;
	}
}
