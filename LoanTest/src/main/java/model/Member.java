package model;

import java.util.ArrayList;

public class Member {
	private String Id;
	public final String getId(){
		return Id;
	}
	public final void setId(String value){
		Id=value;
	}
	private String Name;
	public final String getName(){
		return Name;
	}
	public final void setName(String value){
		Name = value;
	}
	
	private ArrayList<ISpecification<Member>> specifications;
	private ArrayList<Loan> Loans;
	public ArrayList<Loan> getLoans(){
		return Loans;
	}
	public void setLoans(ArrayList<Loan> value){
		Loans=value;
	}
	public final void Return(Book book){
		model.Loan loan=FindCurrentLoanFor(book);
		if(loan !=null){
			loan.MarkAsReturned();
			book.setLoanTo(null);
		}
	}
	public final boolean CanLoan(Book book){
		if(book.getLoanTo()!=null){
			return false;
		}else{
			return validate();
			}
		}
	public final Loan Loan(Book book){
		Loan loan=null;
		if(CanLoan(book)){
			loan=LoanFactory.CreateLoan(book,this);
			getLoans().add(loan);
		}
		return loan;
	}
	private Loan FindCurrentLoanFor(Book book){
		return (model.Loan) getLoans().stream().filter(loan ->(book.getId().equals(loan.getBook().getId()) && loan.HasNotBeenReturned()));
	}
	private boolean validate(){
		boolean result=false;
		for(ISpecification<Member> spec:specifications){
			result= spec.IsSatisfiedBy(this);
			if(!result)return false;
		}
		return result;
	}
	public ArrayList<ISpecification<Member>> getSpecification() {
		return specifications;
	}
}
