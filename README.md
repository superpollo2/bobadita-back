#!/bin/bash

# Limpiar todas las reglas previas
iptables -F
iptables -X

# Establecer la política por defecto a 'DROP' para todo el tráfico
iptables -P INPUT DROP
iptables -P FORWARD DROP
iptables -P OUTPUT ACCEPT

# Aceptar tráfico en la interfaz de loopback (localhost)
iptables -A INPUT -i lo -j ACCEPT
iptables -A OUTPUT -o lo -j ACCEPT

# Permitir tráfico ICMP (ping) para diagnóstico
iptables -A INPUT -p icmp --icmp-type echo-request -j ACCEPT

# Permitir tráfico SSH en el puerto 22 (si necesitas acceso remoto)
iptables -A INPUT -p tcp --dport 22 -j ACCEPT

# Permitir tráfico HTTP (puerto 80) y HTTPS (puerto 443)
iptables -A INPUT -p tcp --dport 80 -j ACCEPT
iptables -A INPUT -p tcp --dport 443 -j ACCEPT

# Limitar conexiones por IP para prevenir DDoS (máximo 10 conexiones por minuto)
iptables -A INPUT -p tcp --syn -m limit --limit 10/min -j ACCEPT

# Limitar la tasa de conexiones de un solo cliente
iptables -A INPUT -p tcp --syn -m recent --set
iptables -A INPUT -p tcp --syn -m recent --update --seconds 60 --hitcount 100 -j DROP

# Registrar los intentos de conexión (opcional)
iptables -A INPUT -j LOG --log-prefix "iptables: " --log-level 7
