-- Insert 10 Companies
INSERT INTO company (name, description) VALUES
    ('Company One', 'Description for Company One'),
    ('Company Two', 'Description for Company Two'),
    ('Company Three', 'Description for Company Three'),
    ('Company Four', 'Description for Company Four'),
    ('Company Five', 'Description for Company Five'),
    ('Company Six', 'Description for Company Six'),
    ('Company Seven', 'Description for Company Seven'),
    ('Company Eight', 'Description for Company Eight'),
    ('Company Nine', 'Description for Company Nine'),
    ('Company Ten', 'Description for Company Ten');


-- Insert 50 Jobs (5 per Company)
INSERT INTO job (title, description, min_salary, max_salary, location, company_id) VALUES
    ('Job One for Company One', 'Description for Job One', '5000', '7000', 'Location One', 1),
    ('Job Two for Company One', 'Description for Job Two', '5500', '7500', 'Location One', 1),
    ('Job Three for Company One', 'Description for Job Three', '6000', '8000', 'Location One', 1),
    ('Job Four for Company One', 'Description for Job Four', '6200', '8200', 'Location One', 1),
    ('Job Five for Company One', 'Description for Job Five', '7000', '9000', 'Location One', 1),

    ('Job One for Company Two', 'Description for Job One', '4800', '6800', 'Location Two', 2),
    ('Job Two for Company Two', 'Description for Job Two', '5200', '7200', 'Location Two', 2),
    ('Job Three for Company Two', 'Description for Job Three', '5400', '7400', 'Location Two', 2),
    ('Job Four for Company Two', 'Description for Job Four', '5600', '7600', 'Location Two', 2),
    ('Job Five for Company Two', 'Description for Job Five', '5900', '7900', 'Location Two', 2),

    ('Job One for Company Three', 'Description for Job One', '4900', '6900', 'Location Three', 3),
    ('Job Two for Company Three', 'Description for Job Two', '5100', '7100', 'Location Three', 3),
    ('Job Three for Company Three', 'Description for Job Three', '5300', '7300', 'Location Three', 3),
    ('Job Four for Company Three', 'Description for Job Four', '5500', '7500', 'Location Three', 3),
    ('Job Five for Company Three', 'Description for Job Five', '5800', '7800', 'Location Three', 3),

    ('Job One for Company Four', 'Description for Job One', '6000', '8000', 'Location Four', 4),
    ('Job Two for Company Four', 'Description for Job Two', '6200', '8200', 'Location Four', 4),
    ('Job Three for Company Four', 'Description for Job Three', '6400', '8400', 'Location Four', 4),
    ('Job Four for Company Four', 'Description for Job Four', '6600', '8600', 'Location Four', 4),
    ('Job Five for Company Four', 'Description for Job Five', '6800', '8800', 'Location Four', 4),

    ('Job One for Company Five', 'Description for Job One', '4500', '6500', 'Location Five', 5),
    ('Job Two for Company Five', 'Description for Job Two', '4700', '6700', 'Location Five', 5),
    ('Job Three for Company Five', 'Description for Job Three', '4900', '6900', 'Location Five', 5),
    ('Job Four for Company Five', 'Description for Job Four', '5100', '7100', 'Location Five', 5),
    ('Job Five for Company Five', 'Description for Job Five', '5300', '7300', 'Location Five', 5),

    ('Job One for Company Six', 'Description for Job One', '4700', '6700', 'Location Six', 6),
    ('Job Two for Company Six', 'Description for Job Two', '4900', '6900', 'Location Six', 6),
    ('Job Three for Company Six', 'Description for Job Three', '5100', '7100', 'Location Six', 6),
    ('Job Four for Company Six', 'Description for Job Four', '5300', '7300', 'Location Six', 6),
    ('Job Five for Company Six', 'Description for Job Five', '5500', '7500', 'Location Six', 6),

    ('Job One for Company Seven', 'Description for Job One', '4200', '6200', 'Location Seven', 7),
    ('Job Two for Company Seven', 'Description for Job Two', '4400', '6400', 'Location Seven', 7),
    ('Job Three for Company Seven', 'Description for Job Three', '4600', '6600', 'Location Seven', 7),
    ('Job Four for Company Seven', 'Description for Job Four', '4800', '6800', 'Location Seven', 7),
    ('Job Five for Company Seven', 'Description for Job Five', '5000', '7000', 'Location Seven', 7),

    ('Job One for Company Eight', 'Description for Job One', '3900', '5900', 'Location Eight', 8),
    ('Job Two for Company Eight', 'Description for Job Two', '4100', '6100', 'Location Eight', 8),
    ('Job Three for Company Eight', 'Description for Job Three', '4300', '6300', 'Location Eight', 8),
    ('Job Four for Company Eight', 'Description for Job Four', '4500', '6500', 'Location Eight', 8),
    ('Job Five for Company Eight', 'Description for Job Five', '4700', '6700', 'Location Eight', 8),

    ('Job One for Company Nine', 'Description for Job One', '3700', '5700', 'Location Nine', 9),
    ('Job Two for Company Nine', 'Description for Job Two', '3900', '5900', 'Location Nine', 9),
    ('Job Three for Company Nine', 'Description for Job Three', '4100', '6100', 'Location Nine', 9),
    ('Job Four for Company Nine', 'Description for Job Four', '4300', '6300', 'Location Nine', 9),
    ('Job Five for Company Nine', 'Description for Job Five', '4500', '6500', 'Location Nine', 9),

    ('Job One for Company Ten', 'Description for Job One', '3500', '5500', 'Location Ten', 10),
    ('Job Two for Company Ten', 'Description for Job Two', '3700', '5700', 'Location Ten', 10),
    ('Job Three for Company Ten', 'Description for Job Three', '3900', '5900', 'Location Ten', 10),
    ('Job Four for Company Ten', 'Description for Job Four', '4100', '6100', 'Location Ten', 10),
    ('Job Five for Company Ten', 'Description for Job Five', '4300', '6300', 'Location Ten', 10);


-- Insert 50 Reviews (5 per Company)
INSERT INTO review (title, description, rating, company_id) VALUES
    ('Review One for Company One', 'Great company to work for!', 5, 1),
    ('Review Two for Company One', 'Had a fantastic experience.', 4, 1),
    ('Review Three for Company One', 'Good work-life balance.', 4.5, 1),
    ('Review Four for Company One', 'Friendly environment.', 5, 1),
    ('Review Five for Company One', 'Would recommend to others.', 4.8, 1),

    ('Review One for Company Two', 'Supportive management.', 4, 2),
    ('Review Two for Company Two', 'Learning opportunities.', 4.5, 2),
    ('Review Three for Company Two', 'Great team culture.', 5, 2),
    ('Review Four for Company Two', 'Flexible hours.', 4.2, 2),
    ('Review Five for Company Two', 'Nice office environment.', 4.7, 2),

    ('Review One for Company Three', 'Challenging work.', 4, 3),
    ('Review Two for Company Three', 'Good benefits.', 4.3, 3),
    ('Review Three for Company Three', 'Professional growth.', 5, 3),
    ('Review Four for Company Three', 'Great projects to work on.', 4.5, 3),
    ('Review Five for Company Three', 'Supportive colleagues.', 4.7, 3),

    ('Review One for Company Four', 'Innovative environment.', 5, 4),
    ('Review Two for Company Four', 'Good training programs.', 4.8, 4),
    ('Review Three for Company Four', 'Collaborative culture.', 4.2, 4),
    ('Review Four for Company Four', 'Great location.', 4.5, 4),
    ('Review Five for Company Four', 'Management is approachable.', 4.7, 4),

    ('Review One for Company Five', 'Stable workplace.', 4, 5),
    ('Review Two for Company Five', 'Well-structured organization.', 4.2, 5),
    ('Review Three for Company Five', 'Friendly staff.', 4.5, 5),
    ('Review Four for Company Five', 'Good work-life balance.', 4.8, 5),
    ('Review Five for Company Five', 'Valuable experience.', 4.9, 5),

    ('Review One for Company Six', 'Professional environment.', 4, 6),
    ('Review Two for Company Six', 'Decent salary.', 4.5, 6),
    ('Review Three for Company Six', 'Supportive team.', 4.3, 6),
    ('Review Four for Company Six', 'Growth opportunities.', 5, 6),
    ('Review Five for Company Six', 'Work is rewarding.', 4.6, 6),

    ('Review One for Company Seven', 'Motivating atmosphere.', 4, 7),
    ('Review Two for Company Seven', 'Helpful managers.', 4.4, 7),
    ('Review Three for Company Seven', 'Room for improvement.', 3.5, 7),
    ('Review Four for Company Seven', 'Focused on results.', 4.3, 7),
    ('Review Five for Company Seven', 'Good communication.', 4.6, 7),

    ('Review One for Company Eight', 'Good ethical standards.', 5, 8),
    ('Review Two for Company Eight', 'Great company values.', 4.8, 8),
    ('Review Three for Company Eight', 'Diverse workplace.', 4.5, 8),
    ('Review Four for Company Eight', 'Respectful environment.', 4.2, 8),
    ('Review Five for Company Eight', 'Excellent leadership.', 4.7, 8),

    ('Review One for Company Nine', 'Dynamic team.', 4, 9),
    ('Review Two for Company Nine', 'Encouraging work culture.', 4.2, 9),
    ('Review Three for Company Nine', 'Work is enjoyable.', 4.5, 9),
    ('Review Four for Company Nine', 'Focus on innovation.', 4.6, 9),
    ('Review Five for Company Nine', 'Excellent training.', 4.8, 9),

    ('Review One for Company Ten', 'Overall positive experience.', 4, 10),
    ('Review Two for Company Ten', 'Management is supportive.', 4.3, 10),
    ('Review Three for Company Ten', 'Encouraging work environment.', 4.5, 10),
    ('Review Four for Company Ten', 'Good feedback culture.', 4.4, 10),
    ('Review Five for Company Ten', 'Room for growth.', 4.6, 10);
