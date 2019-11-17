package com.blog.processor;

import com.blog.models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<Blog, Long> {

    @Query(value = "SELECT * FROM blogs where is_active = true ORDER BY created_at DESC LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Blog> findBlogs(final @Param("limit") int limit, final @Param("offset") int offset);

}
