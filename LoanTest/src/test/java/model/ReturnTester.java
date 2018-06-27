package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class ReturnTester {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@Test
	public void test() {
		Member memberA=new Member();
		memberA.setId("1");
		memberA.setName("simon");
		memberA.setLoans(new ArrayList<Loan>());
		Book book1=new Book();
		book1.setId("1");
		book1.setISBN("ISBN-001-001");
		book1.setTitle("系统分析与设计");
		Book book2=new Book();
		book2.setId("2");
		book2.setISBN("ISBN-002-002");
		book2.setTitle("网页设计基础");
		Book book3=new Book();
		book3.setId("3");
		book3.setISBN("ISBN-001-001");
		book3.setTitle("系统分析与设计");
        if(memberA.CanLoan(book1)){
        	memberA.Loan(book1);
        }
        System.out.println(LocalDateTime.now()+"您已借阅《系统分析与设计》");
        if(memberA.CanLoan(book2)){
        	memberA.Loan(book2);
        }
        System.out.println(LocalDateTime.now()+"您已借阅《网页设计基础》");
        if(memberA.CanLoan(book3)){
        	memberA.Loan(book3);
        }
        memberA.Return(book1);
        System.out.println(LocalDateTime.now()+"您已归还《系统分析与设计》");
	}
}
