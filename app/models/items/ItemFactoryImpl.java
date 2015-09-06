package models.items;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

/**
 * Creates instances of {@link Item}.
 * <p>
 * Delegates the creation (facade for creating) {@link Tag}, {@link Field}, and {@link Rating} instances.
 */
class ItemFactoryImpl implements ItemFactory {

    private TagFactory tagFactory;

    @Inject
    ItemFactoryImpl(TagFactory tagFactory) {
        this.tagFactory = tagFactory;
    }

    @Override
    public Item createItem(int id, String itemName, String username) {
        return this.createItem(id, itemName, username, null, null, null);
    }

    @Override
    public Item createItem(int id, String itemName, String username, Set<Tag> tags, List<Field> fields, List<Rating> ratings) {
        return new ItemImpl(id, itemName, username, tags, fields, ratings);
    }

    @Override
    public Item createItem(Item item) {

        int id = item.getId();
        String name = item.getName();
        String username = item.getUsername();
        Set<Tag> tags = item.getTags();
        List<Field> fields = item.getFields();
        List<Rating> ratings = item.getRatings();

        return this.createItem(id, name, username, tags, fields, ratings);
    }

    @Override
    public Tag createTag(int id, String name, String username) {
        return tagFactory.createTag(id, name, username);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagFactory.createTag(tag);
    }

    @Override
    public Field createField(int id, String fieldKey, String fieldValue) {
        return null;
    }

    @Override
    public Field createField(Field field) {
        return null;
    }

    @Override
    public Rating createRating(int id, String ratingKey, int ratingValue) {
        return null;
    }

    @Override
    public Rating createRating(Rating rating) {
        return null;
    }

}