package com.bodhare.immunisation.repository;

import com.bodhare.immunisation.model.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

    @Query("select s from SubscriptionEntity s where s.email = ?1")
    SubscriptionEntity findByEmail(String email);
}
