package br.com.mertens.notification.services;

import br.com.mertens.notification.models.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface NotificationService {

    NotificationModel saveNotification(NotificationModel notificationModel);

    Page<NotificationModel> findAllNotificationsByUser(UUID userId, Pageable pageable);

    Optional<NotificationModel> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
