package com.example.demo.brand;

import java.io.Serializable;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class EntityLocaleId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long entityId;
	private Long langId;

	public Long getBrandId() {
		return entityId;
	}

	public void setBrandId(Long brandId) {
		this.entityId = brandId;
	}

	public Long getLangId() {
		return langId;
	}

	public void setLangId(Long langId) {
		this.langId = langId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof EntityLocaleId))
			return false;
		EntityLocaleId saleId = (EntityLocaleId) o;
		return Objects.equals(getBrandId(), saleId.getBrandId()) && Objects.equals(getLangId(), saleId.getBrandId());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getLangId(), getBrandId());
	}
}