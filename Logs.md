docker logs container 2>&1 | grep "Searchword" - Find specific log by name
docker logs --since=2m <container_id> // since last 2 minutes
docker logs --since=1h <container_id> // since last 1 hour
docker logs -f <container name> --tail 10 - this will show the log starting from the last 10 lines onwards
docker logs -f <container name> - Live log watching
docker logs --since 2023-01-25 -t container_name_or_ID - show the logs from 25th January 2023.
docker logs -f <container name> | grep "certain text" - live container loggin with certain word
docker-compose logs --tail=0 --follow - If using docker-compose
docker ps -q | xargs -L 1 docker logs - logs for all running containers
docker ps -q | xargs -L 1 -P `docker ps | wc -l` docker logs --since 30s -f - multiple container logs
watch 'docker ps --format "{{.Names}}" | sort | xargs --verbose --max-args=1 -- docker logs --tail=8 --timestamps' - dirty multitail/xtail for docker containers
