package com.stroev.storage;
import com.stroev.exception.ExistStorageException;
import com.stroev.exception.NotExistStorageException;
import com.stroev.exception.StorageException;
import com.stroev.model.Resume;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public abstract class AbstractStorage implements Storage{
    protected final Comparator<Resume> R_COMPARATOR = (r1, r2) -> {
        String name1 = r1.getFullName();
        String name2 = r2.getFullName();
        if(name1.equals(name2)){
            return r1.getUuid().compareTo(r2.getUuid());
        }
        return name1.compareTo(name2);
    };

    public Resume get(String uuid) {
        LOG.info("get "+uuid);
        if (exist(uuid)) {
            return get_implements(uuid);
        }
        LOG.warning("Resume "+uuid+" not exist");
        throw new NotExistStorageException(uuid);
    }
    public void update(Resume r){
        String uuid = r.getUuid();
        LOG.info("update "+ uuid);
        if(exist(uuid)){
            get_update(r);
        }else{
            LOG.warning("Resume "+uuid+" not exist");
            throw new NotExistStorageException(uuid);
        }
    }
    public void save(Resume r){
        String uuid = r.getUuid();
        LOG.info("save "+ uuid);
        if (exist(uuid)){
            LOG.warning("Resume"+uuid+"already exist");
            throw new ExistStorageException(uuid);
        }else {
            get_save(r);
        }
    }
    public void delete(String uuid) {
        LOG.info("delete "+ uuid);
        if(!exist(uuid)){
            LOG.warning("Resume "+uuid+" not exist");
            throw new NotExistStorageException(uuid);
        }else {
            get_delete(uuid);
        }
    }

    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> s = getAllCopy();
        s.sort(R_COMPARATOR);
        return s;
    }

    //protected final Logger log = Logger.getLogger(getClass().getName());
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());
    protected abstract List<Resume> getAllCopy();
    protected abstract Resume get_implements(String uuid);
    protected abstract void get_update(Resume r);
    protected abstract void get_save(Resume r);
    protected abstract void get_delete(String uuid);
    protected abstract boolean exist(String uuid);

}