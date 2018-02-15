package com.raxdenstudios.data.repository.mapper;

import android.content.Context;

import com.raxdenstudios.commons.ModelDataMapper;
import com.raxdenstudios.data.entity.SampleEntity;
import com.raxdenstudios.domain.SampleDomain;

import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Angel on 27/09/2017.
 */

@Singleton
public class SampleEntityDataMapper extends ModelDataMapper<SampleEntity, SampleDomain> {

    @Inject
    public SampleEntityDataMapper(Context context, ModelMapper modelMapper) {
        super(context, modelMapper);
    }

    @Override
    public SampleDomain transform(SampleEntity source) {
        return getModelMapper().map(source, SampleDomain.class);
    }

    @Override
    public SampleEntity inverseTransform(SampleDomain source) {
        return getModelMapper().map(source, SampleEntity.class);
    }

    @Override
    public boolean equals(SampleEntity source, SampleDomain destination) {
        return false;
    }
}