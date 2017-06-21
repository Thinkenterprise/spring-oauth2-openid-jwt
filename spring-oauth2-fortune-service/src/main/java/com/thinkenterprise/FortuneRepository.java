package com.thinkenterprise;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FortuneRepository extends CrudRepository<Fortune, Long>{

    @Query("select fortune from Fortune fortune order by RAND()")
    public Iterable<Fortune> randomFortunes();
}
