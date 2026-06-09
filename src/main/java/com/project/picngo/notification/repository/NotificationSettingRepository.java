package com.project.picngo.notification.repository;

import com.project.picngo.notification.domain.NotificationSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NotificationSettingRepository extends JpaRepository<NotificationSetting, Long> {
    Optional<NotificationSetting> findByUserId(Long userId);
}
