package cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Projection;
import cinema.repository.ProjectionRepository;
import cinema.service.ProjectionService;

@Service
public class JpaProjectionService implements ProjectionService {

	@Autowired
	private ProjectionRepository projectionRepository;

	@Override
	public Projection findOne(Long id) {
		return projectionRepository.findById(id).orElse(null);
	}

	@Override
	public List<Projection> findAll() {
		return projectionRepository.findAll();
	}

	@Override
	public Projection save(Projection projection) {
		LocalDateTime dateTime = projection.getDateTime();
		int hour = dateTime.getHour();
		String projectionType = projection.getProjectionType().getType();
		boolean isWeekend = dateTime.getDayOfWeek().name().equals("SATURDAY")
				|| dateTime.getDayOfWeek().name().equals("SUNDAY");

		double price = 0;
		if (projectionType.equals("2D")) {
			if (hour < 15 && !isWeekend) {
				price = 500;
			} else if (hour < 18 && !isWeekend) {
				price = 550;
			} else if (hour >= 18 && !isWeekend) {
				price = 600;
			} else if (hour < 15 && isWeekend) {
				price = 550;
			} else if (hour < 18 && isWeekend) {
				price = 600;
			} else if (hour >= 18 && isWeekend) {
				price = 650;
			}
		}

		if (projectionType.equals("3D")) {
			if (hour < 15 && !isWeekend) {
				price = 700;
			} else if (hour < 18 && !isWeekend) {
				price = 750;
			} else if (hour >= 18 && !isWeekend) {
				price = 800;
			} else if (hour < 15 && isWeekend) {
				price = 750;
			} else if (hour < 18 && isWeekend) {
				price = 800;
			} else if (hour >= 18 && isWeekend) {
				price = 850;
			}
		}

		if (projectionType.equals("4D")) {
			if (hour < 15 && !isWeekend) {
				price = 900;
			} else if (hour < 18 && !isWeekend) {
				price = 950;
			} else if (hour >= 18 && !isWeekend) {
				price = 1000;
			} else if (hour < 15 && isWeekend) {
				price = 950;
			} else if (hour < 18 && isWeekend) {
				price = 1000;
			} else if (hour >= 18 && isWeekend) {
				price = 1050;
			}
		}
		
		projection.setPrice(price);

		return projectionRepository.save(projection);
	}

	@Override
	public Projection delete(Long id) {
		Projection projection = findOne(id);

		if (projection != null) {
			projection.getFilm().getProjections().remove(projection);
			projection.getAuditorium().getProjections().remove(projection);
			projection.getProjectionType().getProjections().remove(projection);
			projectionRepository.delete(projection);
		}

		return projection;
	}

	@Override
	public List<Projection> findByFilmId(Long filmId) {
		return projectionRepository.findByFilmId(filmId);
	}

}
