package model;

import java.time.LocalDateTime;

public class LoanFactory {
	public static Loan CreateLoan(Book book,Member member){
		Loan loan= new Loan();
		loan.setBook(book);
		loan.getBook().setLoanTo(member);
		loan.setMember(member);
		loan.setLoanDate(LocalDateTime.now());
		loan.setDateForReturn(LocalDateTime.now().plusDays(10));
		return loan;
	}
}
