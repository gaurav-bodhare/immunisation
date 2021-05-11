package com.bodhare.immunisation.service.mapper;

import com.bodhare.immunisation.dto.SubscriptionDto;
import com.bodhare.immunisation.model.SubscriptionEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface SubscriptionMapper extends EntityMapper<SubscriptionDto, SubscriptionEntity> {

    default SubscriptionEntity fromId(Long id) {
        if (id == null) {
            return null;
        }
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setSubscriptionId(id);
        return subscriptionEntity;
    }

}
