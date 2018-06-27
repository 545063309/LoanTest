package model;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SpecificationTester {

	@Test
	public void testValueOf(){
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
		ISpecification<Member> spec1=new LoanOnlyOneSpecification(book1);
		ISpecification<Member> spec2=new HasReachMaxSpecification();
		memberA.getSpecification().add(spec1);
		memberA.getSpecification().add(spec2);
		if(memberA.CanLoan(book1)){
			Loan loan1=memberA.Loan(book1);
			book1.setLoanTo(memberA);
			System.out.println("借book1成功！");
		}else{
			System.out.println("借book1失败！");
		}
		if(memberA.CanLoan(book2)){
			Loan loan2=memberA.Loan(book2);
			book2.setLoanTo(memberA);
			System.out.println("借book2成功！");
		}else{
			System.out.println("借book2失败！");
		}
		if(memberA.CanLoan(book3)){
			Loan loan3=memberA.Loan(book3);
			book3.setLoanTo(memberA);
			System.out.println("借book3成功！");
		}else{
			System.out.println("借book3失败！");
		}
		assertTrue("",memberA.getLoans().size()>0);
	}
}
