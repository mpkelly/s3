package org.s3.variable;

import org.s3.expression.Expression;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Choices implements Iterable<Choices.Choice> {

    static class Choice {

        final Condition condition;
        final Expression expression;

        public Choice(Condition condition, Expression expression) {
            this.condition = condition;
            this.expression = expression;
        }
    }

    private final List<Choice> choices;

    public Choices() {
        this.choices = new LinkedList<>();
    }

    @Override
    public Iterator<Choice> iterator() {
        return choices.iterator();
    }

    public void add(Condition condition, Expression expression) {
        choices.add(new Choice(condition, expression));
    }
}
