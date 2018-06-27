package model;

public class HasReachMaxSpecification implements ISpecification<Member> {
	@Override
	public boolean IsSatisfiedBy(Member entity){
		return entity.getLoans().size()>3;
	}
}
