package com.talas.autosalonmanagment.util;

import com.talas.autosalonmanagment.model.BaseEntity;
import jakarta.persistence.Entity;

@Entity
public class Dictionary extends BaseEntity {

    private DictionaryType dictionaryType;

    public enum DictionaryType {
        BRAND,
        CAR_MODEL,
        ENGINE_VOLUME
    }
}
