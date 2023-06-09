package com.gft.test.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomCarDeserializer extends StdDeserializer<Car>{
	public CustomCarDeserializer() {
        this(null);
    }

    public CustomCarDeserializer(Class<Car> t) {
        super(t);
    }

    @Override
    public Car deserialize(JsonParser parser, DeserializationContext deserializer) {
        Car car = new Car();
        ObjectCodec codec = parser.getCodec();
        JsonNode node;
		try 
		{
			node = codec.readTree(parser);
	        // try catch block
	        JsonNode colorNode = node.get("color");
	        String color = colorNode.asText() + " custom !";
	        car.setColor(color);
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return car;
    }

    
}
