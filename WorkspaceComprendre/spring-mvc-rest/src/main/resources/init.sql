INSERT IGNORE INTO `Role` (`id`, `description`, `name`) VALUES
  (1, 'ROLE_ADMIN', 'Admin'),
  (2, 'ROLE_USER', 'Utilisateur');

  INSERT IGNORE INTO `Client` (`id`, `nom`, `password`, `role_id`) VALUES
  (1, 'paul', 'aaa', 1),
  (2, 'roger','aaa', 2);