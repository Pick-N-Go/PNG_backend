package com.project.picngo.notification.service;

import com.project.picngo.notification.dto.NotificationResponse;
import com.project.picngo.notification.dto.NotificationSettingUpdateRequest;
import com.project.picngo.notification.repository.NotificationRepository;
import com.project.picngo.notification.repository.NotificationSettingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationSettingRepository notificationSettingRepository;

    public List<NotificationResponse> getNotifications(Long userId) {
        // TODO: Implement get notifications logic
        return List.of();
    }

    @Transactional
    public void markAsRead(Long id) {
        // TODO: Implement mark as read logic
    }

    @Transactional
    public void updateSettings(Long userId, NotificationSettingUpdateRequest request) {
        // TODO: Implement update settings logic
    }

    @Transactional
    public void sendPushNotification(Long userId, String type, String title, String content, String deepLink) {
        // TODO: Call FCM API (using WebClient) and save Notification entity to DB
    }
}
