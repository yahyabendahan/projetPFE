package com.example.cdl1;

import org.springframework.batch.item.Chunk;

public interface ItemWriter<T> {

    void write(Chunk<? extends T> items) throws Exception;

}


