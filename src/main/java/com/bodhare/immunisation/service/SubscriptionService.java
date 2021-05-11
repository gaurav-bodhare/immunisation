package com.bodhare.immunisation.service;

import com.bodhare.immunisation.dto.SubscriptionDto;
import com.bodhare.immunisation.service.mapper.SubscriptionMapper;
import com.bodhare.immunisation.model.SubscriptionEntity;
import com.bodhare.immunisation.repository.SubscriptionRepository;

import java.util.List;

public class SubscriptionService {

    private SubscriptionMapper subscriptionMapper;

    private SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionMapper subscriptionMapper, SubscriptionRepository subscriptionRepository) {
        this.subscriptionMapper = subscriptionMapper;
        this.subscriptionRepository = subscriptionRepository;
    }

    protected SubscriptionDto addSubscription(SubscriptionDto subscriptionDto) {
        SubscriptionEntity subscriptionEntity = subscriptionRepository.findByEmail(subscriptionDto.getEmail());
        if (subscriptionEntity != null) {
            subscriptionDto.setSubscriptionId(subscriptionEntity.getSubscriptionId());
        }
        SubscriptionEntity newEntity = subscriptionRepository.save(subscriptionMapper.toEntity(subscriptionDto));
        return subscriptionMapper.toDto(newEntity);
    }

    protected void deleteSubscription(SubscriptionDto subscriptionDto) {
        SubscriptionEntity subscriptionEntity = subscriptionRepository.findByEmail(subscriptionDto.getEmail());
        subscriptionRepository.deleteById(subscriptionEntity.getSubscriptionId());
    }

    protected List<SubscriptionDto> getAllSubscriptions() {
        List<SubscriptionEntity> subscriptionEntities = subscriptionRepository.findAll();
        return subscriptionMapper.toDto(subscriptionEntities);
    }
}
