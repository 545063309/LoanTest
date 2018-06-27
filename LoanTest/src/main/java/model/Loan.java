package model;
import java.time.LocalDateTime;

public class Loan {
	private String Id;
	public final String getId(){
		return Id;
	}
	public final void setId(String value){
		Id=value;
	}
	private LocalDateTime LoanDate;
	public final LocalDateTime getLoanDate(){
		return LoanDate;
	}
	public final void setLoanDate(LocalDateTime value){
		LoanDate=value;
	}
	private LocalDateTime DateForReturn;
	public final LocalDateTime getDateForReturn(){
		return DateForReturn;
	}
	public final void setDateForReturn(LocalDateTime value){
		DateForReturn=value;
	
	}
	private LocalDateTime ReturnDate;
	public final LocalDateTime getReturnDate(){
		return ReturnDate;
	}
	public final void setReturnDate(LocalDateTime value){
		ReturnDate=value;
	}
	private Book Book;
	public final Book getBook(){
		return Book;
	}
	public final void setBook(Book value){
		Book=value;
	}
	private Member Member;
	public final Member getMember(){
		return Member;
	}
	public final void setMember(Member value){
		Member=value;
	}
	public boolean HasNotBeenReturned(){
		return ReturnDate == null;
	}
	public void MarkAsReturned(){
		ReturnDate = LocalDateTime.now();
	}
}
