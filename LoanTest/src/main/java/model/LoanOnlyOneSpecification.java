package model;

public class LoanOnlyOneSpecification implements ISpecification<Member>{
	private Book wantBook;
	public LoanOnlyOneSpecification(Book book){
		this.wantBook = book;
	}
	@Override
	public boolean IsSatisfiedBy(Member entity){
		return entity.getLoans().stream().anyMatch(loan ->(wantBook.getISBN().equals(loan.getBook().getISBN()) && loan.HasNotBeenReturned()));
	}
}