package shopstyle.example;

import java.util.Optional;

/**
 * An {@link Integer} implementation of {@link Stack}.
 *
 * <p>Instances of this class are not thread-safe.</p>
 */
final class IntegerStack implements Stack<Integer> {

    private final String PROPERTIES_FILE_NAME = "integerstack.properties";
    private final java.util.Stack<Integer> internalStack;

    /**
     * A new IntegerStack.  This IntegerStack is initiated
     * to the value of initialStackSizein integerstack.properties.
     */
    public IntegerStack() {
        PropertiesLoader propertiesLoader = new PropertiesLoader(PROPERTIES_FILE_NAME);
        int stackSize = Integer.valueOf(propertiesLoader.getProperty("initialStackSize"));

        internalStack = new java.util.Stack<>();
        internalStack.setSize(stackSize);
    }

    /**
     * A new IntegerStack of specified size.
     *
     * @param stackSize The size of the stack.
     */
    public IntegerStack(int stackSize) {
        internalStack = new java.util.Stack<>();
        internalStack.setSize(stackSize);
    }

    @Override
    public boolean isEmpty() {
        return internalStack.size() == 0;
    }

    @Override
    public Optional<Integer> peek() {
        if (internalStack.empty()) {
            return Optional.empty();
        }

        Integer value = internalStack.peek();

        return Optional.of(value);
    }

    @Override
    public Optional<Integer> pop() {
        if (internalStack.empty()) {
            return Optional.empty();
        }

        Integer value = internalStack.pop();

        return Optional.of(value);
    }

    @Override
    public void push(Integer value) {
        internalStack.push(value);
    }
}
