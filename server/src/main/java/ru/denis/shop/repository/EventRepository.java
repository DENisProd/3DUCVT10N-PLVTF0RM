package ru.denis.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.denis.shop.models.Event;

import java.util.List;
import java.util.Set;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    @Query(value = "SELECT * FROM event ORDER BY views DESC", nativeQuery = true)
    List<Event> getTopEventsOrderByDesc();

    List<Event> findTop10ByOrderByViewsDesc();

    @Modifying
    @Query(value = "UPDATE event SET views=views+1 WHERE id= :event_id", nativeQuery = true)
    void addViews(@Param("event_id") Long eventId);
}
