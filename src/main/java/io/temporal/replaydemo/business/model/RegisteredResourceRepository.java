package io.temporal.replaydemo.business.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredResourceRepository extends JpaRepository<RegisteredResource, Integer> {}
