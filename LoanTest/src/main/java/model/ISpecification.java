package model;

public interface ISpecification<T> {
	public boolean IsSatisfiedBy(T entity);
}
