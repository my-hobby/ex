package com.ywg.model;
// Generated 2017-2-25 19:54:26 by Hibernate Tools 5.2.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * TFun generated by hbm2java
 */
public class TFun implements java.io.Serializable {

	private TFunId id;
	private Set roletofuns = new HashSet(0);

	public TFun() {
	}

	public TFun(TFunId id) {
		this.id = id;
	}

	public TFun(TFunId id, Set roletofuns) {
		this.id = id;
		this.roletofuns = roletofuns;
	}

	public TFunId getId() {
		return this.id;
	}

	public void setId(TFunId id) {
		this.id = id;
	}

	public Set getRoletofuns() {
		return this.roletofuns;
	}

	public void setRoletofuns(Set roletofuns) {
		this.roletofuns = roletofuns;
	}

}
