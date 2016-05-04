package org.db.sb.svc.domain.entity;

public abstract class AbstractIdDomainEntity<T> {

	private T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
}
