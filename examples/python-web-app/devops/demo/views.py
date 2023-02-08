from django.http import HttpResponse


def index(request):
    return HttpResponse("Welcome to DevOps Zero to Hero by Abhishek Veeramalla")
