package com.isaachome.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class TrackTest extends AbstractPersistenceTest{

	@Test
	void shouldCreateATrack()throws Exception {

	    Track track = new Track("Sgt Pepper Lonely Heart Club Ban", 4.53f,  "Listen to the trumpet carefully, it's George Harrison playing");
	    tx.begin();
	    em.persist(track);
	    tx.commit();
	    assertNotNull(track.getId(),"Id should not be null");
	}

}
