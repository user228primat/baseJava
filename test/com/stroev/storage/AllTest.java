package com.stroev.storage;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        SortedStorageTest.class,
        ListStorageTest.class,
        MapStorageTest.class,
        StorageTest.class
})

public class AllTest { }
