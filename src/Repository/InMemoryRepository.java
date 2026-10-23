package Repository;

import Models.BaseModel;

import java.util.*;

// save, getById(), findAll(), getByRegNo()
public class InMemoryRepository<T extends BaseModel>{
    // LESSON : make T extend BaseModel so that

    Map<Long,T> store = new HashMap<>();
    private static Long lastId = 0l;

    public T save(T item){
        if (item.getId() == null) {
            // If item doesnt exist in DB just set a new id
            item.setId(++lastId);
        }

        if (item.getCreatedAt() == null){
            item.setCreatedAt(new Date());
        }

        item.setUpdatedAt(new Date());
        store.put(item.getId(),item);
        return item;
    }

    public T getById(Long id){
        return store.get(id);
    }

    public List<T> findAll(){
        return new ArrayList<>(store.values());
    }
}