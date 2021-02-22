package com.fyayc.Interview.mapping;

import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Service;

import java.util.IdentityHashMap;
import java.util.Map;

@Service
public class MappingContext {
    private Map<Object, Object> knownInstances = new IdentityHashMap<Object, Object>();

    @BeforeMapping
    public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {
        return (T) knownInstances.get( source );
    }

    @BeforeMapping
    public void storeMappedInstance(Object source, @MappingTarget Object target) {
        knownInstances.put( source, target );
    }
}
