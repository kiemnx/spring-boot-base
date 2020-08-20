package vn.zclouds.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.zclouds.spring.boot.repository.entity.BaseEntity;

@Repository
public interface BaseRepository extends JpaRepository<BaseEntity, Integer> {
}
