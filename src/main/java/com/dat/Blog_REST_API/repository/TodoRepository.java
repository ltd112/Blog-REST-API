package com.dat.Blog_REST_API.repository;

import com.dat.Blog_REST_API.model.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Page<Todo> findByCreateBy(Long userId, Pageable pageable);
}
