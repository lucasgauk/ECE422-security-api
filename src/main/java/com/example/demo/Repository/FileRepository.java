package com.example.demo.Repository;

import com.example.demo.Model.File.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

  File findByPath(String path);

  void deleteAllByPath(String path);

}
