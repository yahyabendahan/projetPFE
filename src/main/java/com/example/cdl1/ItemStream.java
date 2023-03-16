package com.example.cdl1;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;

public interface ItemStream {

    void open(ExecutionContext executionContext) throws ItemStreamException;

    void update(ExecutionContext executionContext) throws ItemStreamException;

    void close() throws ItemStreamException;
}


