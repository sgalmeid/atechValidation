package br.com.atech.test.flightservice.domain;

import org.apache.commons.lang.NotImplementedException;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum FlightStatus {

    WAITING {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(BOARDING_ON_TIME, BOARDING_LATE);
        }
    },
    BOARDING_ON_TIME {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(BOARDING_LATE, DEPARTURE_ON_TIME, DEPARTURE_LATE);
        }
    },
    BOARDING_LATE {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(DEPARTURE_ON_TIME, DEPARTURE_LATE);
        }
    },
    DEPARTURE_ON_TIME {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(DEPARTURE_LATE, FLIGHTING_ON_TIME, FLIGHTING_LATE);
        }
    },
    DEPARTURE_LATE {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(FLIGHTING_ON_TIME, FLIGHTING_LATE);
        }
    },
    FLIGHTING_ON_TIME {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(FLIGHTING_LATE, LANDING_ON_TIME, LANDING_LATE);
        }
    },
    FLIGHTING_LATE {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(FLIGHTING_ON_TIME, LANDING_ON_TIME, LANDING_LATE);
        }
    },
    LANDING_ON_TIME {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Arrays.asList(LANDING_LATE, END_TRIP);
        }
    },
    LANDING_LATE{
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Collections.singletonList(END_TRIP);
        }
    },
    END_TRIP {
        @Override
        protected List<FlightStatus> permitedStatus() {
            return Collections.emptyList();
        }
    };

    public final FlightStatus canGoTo(FlightStatus newStatus) {
        return permitedStatus().stream()
                .filter(f -> f.equals(newStatus)).findFirst()
                .orElseThrow(InvalidParameterException::new);
    }

    protected List<FlightStatus> permitedStatus() {
        throw new NotImplementedException();
    }


}
