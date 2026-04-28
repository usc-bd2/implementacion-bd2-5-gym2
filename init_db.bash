set -e

DB_NAME="gimnasio_bd"
DB_USER="alumnogreibd"

echo "Reiniciando base de datos..."
psql -U "$DB_USER" -d "$DB_NAME" -f sql/reset.sql

echo "Cargando esquema..."
psql -U "$DB_USER" -d "$DB_NAME" -f sql/create.sql

echo "Cargando procedimientos..."
psql -U "$DB_USER" -d "$DB_NAME" -f sql/procedures.sql

echo "Cargando datos iniciales..."
psql -U "$DB_USER" -d "$DB_NAME" -f sql/insertion.sql

echo "Base de datos inicializada correctamente ✅."