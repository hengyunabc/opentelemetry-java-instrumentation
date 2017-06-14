package io.opentracing.contrib.agent.helper;

import com.mongodb.MongoClientOptions;
import io.opentracing.contrib.mongo.TracingCommandListener;
import org.jboss.byteman.rule.Rule;


public class MongoHelper extends DDTracingHelper<MongoClientOptions.Builder> {


	public MongoHelper(Rule rule) {
		super(rule);
	}

	public MongoClientOptions.Builder patch(MongoClientOptions.Builder builder) {
		return super.patch(builder);
	}

	@Override
	protected MongoClientOptions.Builder doPatch(MongoClientOptions.Builder builder) throws Exception {


		TracingCommandListener listener = new TracingCommandListener(tracer);
		builder.addCommandListener(listener);

		return builder;

	}
}
